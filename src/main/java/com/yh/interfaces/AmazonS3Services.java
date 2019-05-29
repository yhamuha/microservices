package com.yh.interfaces;

import org.apache.commons.csv.CSVPrinter;

public interface AmazonS3Services {
    void save(CSVPrinter report);
}
