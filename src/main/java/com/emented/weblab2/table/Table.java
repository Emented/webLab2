package com.emented.weblab2.table;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Value
public class Table implements Serializable {
    List<TableRow> tableElements = new ArrayList<>();
}
