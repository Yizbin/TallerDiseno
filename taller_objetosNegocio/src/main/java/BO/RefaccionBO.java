/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.IRefaccionBO;
import DAO.interfaces.IRefaccionDAO;
import Mappers.interfaces.IRefaccionMapper;

/**
 *
 * @author Abraham Coronel
 */
public class RefaccionBO implements IRefaccionBO {

    private final IRefaccionDAO refacionDAO;
    private final IRefaccionMapper mapper;

    public RefaccionBO(IRefaccionDAO refacionDAO, IRefaccionMapper mapper) {
        this.refacionDAO = refacionDAO;
        this.mapper = mapper;
    }

}
