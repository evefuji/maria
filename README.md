
# Pré-Requisitos

* Maven (Testado na versão 3.5.2)
* Wildfly 11.0.0 Final: Utilizado o Wildfly 
* SGBD Relacional com datasource instalado. 
* Eclipse Oxygen 
* DataSource JDBC configurado no Wildfly conectando com o SGBD Relacional. 


*- Ex no MySQL:

-- Baixar driver JDBC mais recente e copiá-lo para a pasta deployments do Wildfly. [https://jdbc.postgresql.org/download.html](https://jdbc.postgresql.org/download.html) 

-- Configure a conexão com o SGBD no Wildfly. Exemplo de datasource no standalone.xml: 

                <datasource jta="true" jndi-name="java:jboss/datasources/MariaDS" pool-name="MariaDS" enabled="true" use-ccm="true">
                    <connection-url>jdbc:postgresql://localhost:5432/database</connection-url>
                    <driver-class>org.postgresql.Driver</driver-class>
                    <driver>postgresql-42.1.4.jar</driver>
                    <pool>
                        <min-pool-size>5</min-pool-size>
                        <initial-pool-size>5</initial-pool-size>
                        <max-pool-size>10</max-pool-size>
                        <flush-strategy>IdleConnections</flush-strategy>
                    </pool>
                    <security>
                        <user-name>****</user-name>
                        <password>****</password>
                    </security>
                </datasource>



# Liquibase

Criar um arquivo ~/.m2/settings.xml com o seguinte conteúdo (substituindo os dados de conexão conforme necessário):

  <?xml version="1.0" encoding="UTF-8"?>
  <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                        https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository>${user.home}/.m2/repository</localRepository>
    <interactiveMode>true</interactiveMode>
    <usePluginRegistry>false</usePluginRegistry>
    <offline>false</offline>
    
    <profiles>
      <profile>
        <id>default</id>
        
        <activation>
          <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            
          <!-- Base de dados de exemplo -->
        <maria.jdbc.driver>com.mysql.jdbc.Driver</maria.jdbc.driver>
        <maria.jdbc.url>jdbc:mysql://localhost:3306/maria?useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC</maria.jdbc.url>
        <maria.jdbc.username>root</maria.jdbc.username>
        <maria.jdbc.password></maria.jdbc.password>
          
        </properties>
      </profile>
    </profiles>
  </settings>
  
Em seguida, execute mvn liquibase:update
  
# OAuth

Acrescente ao standalone.xml (após a seção extensions): 
  
    <system-properties>
        <property name="login.oauth2.client_secret" value="XXX"/>
        <property name="login.oauth2.client_id" value="XXX"/>
        <property name="login.oauth2.redirect_uri" value="http://localhost:8080/maria/"/>
        <property name="login.oauth2.access_token_uri" value="https://graph.facebook.com/v2.9/oauth/access_token"/>
        <property name="login.oauth2.search_user_from_token_uri" value="https://graph.facebook.com/me"/>
    </system-properties>
  
# Versionamento de API

Utiliza-se versionamento por URL, ex: 

[http://localhost:8080/maria/](http://localhost:8080/maria/) é a versão mais atual.


[http://localhost:8080/maria-0.0.1-SNAPSHOT/](http://localhost:8080/maria-0.0.1-SNAPSHOT/) é a versão 0.0.1-SNAPSHOT (não final).


[http://localhost:8080/maria-1.0.0/](http://localhost:8080/maria-1.0.0/) é a versão 1.0.0 final.  

# Melhorias futuras 
* Utilizar ElasticSearch para pesquisas de texto: [https://www.elastic.co/guide/en/elasticsearch/reference/current/windows.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/windows.html)

* Adicionar HATEOAS nas mensagens
 
* Criar jobs no Jenkins para compilar e implantar (necessita servidor)

* Adicionar testes automatizados com o Arquillian 

* Enriquecer Javadoc

* Implementar frontend com tecnologias mais robustas, que forneçam mais recursos