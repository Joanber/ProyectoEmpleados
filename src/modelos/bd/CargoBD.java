/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Conexion;
import modelos.md.Cargo;

/**
 *
 * @author Skull
 */
public class CargoBD extends Cargo {
    public static boolean insertar(Cargo cargo){
        String INSERT="INSERT INTO public.\"Cargo\"(\n" +
"	nombre)\n" +
"	VALUES ( '"+cargo.getNombre()+"');";
        return Conexion.PrepareStatement(INSERT)==null;
    }
    public static boolean update(Cargo cargo){
        String UPDATE="UPDATE public.\"Cargo\"\n" +
"	set nombre='"+cargo.getNombre()+"'\n" +
"	WHERE id="+cargo.getId()+";";
        System.out.println("update--------------->>>>>>>>>>>"+UPDATE);
        return Conexion.PrepareStatement(UPDATE)==null;
    }
    public static boolean delete(int id){
        String DELETE="DELETE FROM public.\"Cargo\"\n" +
"	WHERE id="+id+";";
        System.out.println(DELETE);
        return Conexion.PrepareStatement(DELETE)==null;
        
    }
    
    public static ArrayList<Cargo> getCargos(String nombre){
            String SELECT="SELECT id, nombre\n" +
                    "	FROM public.\"Cargo\" WHERE nombre ILIKE '%"+nombre+"%'; ";
            ArrayList<Cargo> lista=new ArrayList<>();
            ResultSet rs=Conexion.Query(SELECT);
            
        try {
            while(rs.next()){
                Cargo cargo=generarCargo(rs);
                lista.add(cargo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista;
    }
    
    public static Cargo generarCargo(ResultSet rs){
        
        try {
            Cargo cargo=new Cargo();
            cargo.setId(rs.getInt(1));
            cargo.setNombre(rs.getString(2));
            return cargo;
        } catch (SQLException ex) {
            Logger.getLogger(CargoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Cargo getCargopor(int id){
            String SELECT="SELECT id, nombre\n" +
                    "	FROM public.\"Cargo\" WHERE id="+id+"";
            Cargo cargo=null;
            ResultSet rs=Conexion.Query(SELECT);
        try {
            while(rs.next()){
                cargo=generarCargo(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargo;
    }
    
}
