package com.emented.weblab2.table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@Getter
@AllArgsConstructor
@ToString
public class TableRow implements Serializable {

    private final int x;
    private final double y;
    private final int r;
    private final boolean hit;
    private final Instant date;
    private final double scriptTime;

}
