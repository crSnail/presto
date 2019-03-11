/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.plugin.clickhouse;

import com.facebook.presto.plugin.jdbc.BaseJdbcConfig;
import com.facebook.presto.plugin.jdbc.JdbcClient;
import com.facebook.presto.plugin.jdbc.QueryBuilder;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;
//import com.google.inject.name.Names;

import static io.airlift.configuration.ConfigBinder.configBinder;

public class ClickhouseClientModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        binder.bind(JdbcClient.class).to(ClickhouseClient.class).in(Scopes.SINGLETON);
        binder.bind(QueryBuilder.class).toInstance(new ClickhouseQueryBuilder("\""));
//        binder.bind(QueryBuilder.class).annotatedWith(Names.named("quote")).to(ClickhouseQueryBuilder.class).in(Scopes.SINGLETON);
//        try {
//            binder.bind(QueryBuilder.class).toConstructor(ClickhouseQueryBuilder.class.getConstructor(String.class));
//        }
//        catch (NoSuchMethodException E) {
//            System.err.println(E.toString());
//        }
        configBinder(binder).bindConfig(BaseJdbcConfig.class);
    }
}
