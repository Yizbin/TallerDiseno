/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.interfaces.IVentaRefaccionDAO;

/**
 *
 * @author Pride Factor Black
 */
public class VentaRefaccionDAO implements IVentaRefaccionDAO{
    
    public IVentaRefaccionDAO instancia;

    public IVentaRefaccionDAO getInstancia() {
        if (instancia==null) {
            instancia = new VentaRefaccionDAO();
        }
        return instancia;
    }

    public VentaRefaccionDAO() {
    }
    
    
}
