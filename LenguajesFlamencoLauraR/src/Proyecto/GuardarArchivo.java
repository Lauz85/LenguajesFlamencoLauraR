package Proyecto;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.io.File;
import java.util.ArrayList;
public class GuardarArchivo {
    
    public synchronized static ArrayList<Archivo> leer()throws Exception{
   File file=new File("archiva");    
 
    FileInputStream fis=new FileInputStream(file);
    ObjectInputStream  ois=new ObjectInputStream(fis);
  ArrayList<Archivo> u=(ArrayList<Archivo>)  ois.readObject();
  ois.close();
     //System.out.println(u);
  return u;
     
  }
    
    public synchronized static Archivo leerUno(String nombre)throws Exception{
   File file=new File("archiva");    
 Archivo ar=null;
    FileInputStream fis=new FileInputStream(file);
    ObjectInputStream  ois=new ObjectInputStream(fis);
    
  ArrayList<Archivo> u=(ArrayList<Archivo>)  ois.readObject();
  
  for(Archivo a:u){
   if(nombre.equalsIgnoreCase(a.getNombre()))  {
       ar=a;
     
       a.getArchivito();
       File salida=a.getArchivito();
       System.out.println(nombre);
      System.out.println(salida.length());
 
  }
  ois.close();
  return ar;
  }
    
    public static void guardar(Archivo u)throws Exception{
        ArrayList usuarios=new ArrayList<Archivo>();
        
       File file=new File("archiva");    
         if(file.exists()){
           usuarios=  leer();
         }
    FileOutputStream fis=new FileOutputStream(file);
    ObjectOutputStream  ois=new ObjectOutputStream(fis);
    usuarios.add(u);
     ois.writeObject(usuarios); 
    ois.close();
  System.out.println("Guardado");
    }
    
}
