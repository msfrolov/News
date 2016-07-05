package com.epam.msfrolov.dto;

import java.io.Serializable;

/**
 * Class for transfer data between view and controller
 */
public class ArrayDTO implements Serializable {

    private Integer[] ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
