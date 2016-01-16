#!/bin/bash
sudo -u postgres pg_dump -c wrightemployees > ./dumps/wrightemployees.pgdump
