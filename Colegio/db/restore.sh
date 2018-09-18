#!/bin/bash
psql -U rbm -W colegio -h localhost < drop.sql
psql -U rbm -W colegio -h localhost < colegio.sql
