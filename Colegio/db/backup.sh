#!/bin/bash
pg_dump -U rbm -W colegio -h localhost > colegio.sql
