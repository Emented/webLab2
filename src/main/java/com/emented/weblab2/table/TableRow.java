package com.emented.weblab2.table;


import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Value
public class TableRow implements Serializable {

    int x;
    double y;
    int r;
    boolean hit;
    Instant date;
    double scriptTime;

}
