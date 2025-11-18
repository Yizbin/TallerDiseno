/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import BO.interfaces.ITareaBO;
import DAO.interfaces.ITareaDAO;
import Mappers.interfaces.ITareaMapper;

/**
 *
 * @author Abraham Coronel
 */
public class TareaBO implements ITareaBO {

    private final ITareaDAO tareaDAO;
    private final ITareaMapper mapper;

    public TareaBO(ITareaDAO tareaDAO, ITareaMapper mapper) {
        this.tareaDAO = tareaDAO;
        this.mapper = mapper;
    }

}
