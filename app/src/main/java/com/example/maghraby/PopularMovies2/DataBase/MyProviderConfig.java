package com.example.maghraby.PopularMovies2.DataBase;


import ckm.simple.sql_provider.UpgradeScript;
import ckm.simple.sql_provider.annotation.ProviderConfig;
import ckm.simple.sql_provider.annotation.SimpleSQLConfig;

    @SimpleSQLConfig(
            name = "MovieProvider",
            authority = "com.example.maghraby.PopularMovies2.provider.authority",
            database = "test.db",
            version = 1)
    public class MyProviderConfig implements ProviderConfig {
        @Override
        public UpgradeScript[] getUpdateScripts() {
            return new UpgradeScript[0];
        }
    }
