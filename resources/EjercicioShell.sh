#! /bin/bash

cat Sacramentorealestatetransactions.csv  | wc -l

head -10 Sacramentorealestatetransactions.csv

tail -10 Sacramentorealestatetransactions.csv

cat Sacramentorealestatetransactions.csv | grep Multi-Family
