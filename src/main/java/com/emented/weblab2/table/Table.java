package com.emented.weblab2.table;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Table implements Serializable {
    private List<TableRow> tableElements = new ArrayList<>();
}
