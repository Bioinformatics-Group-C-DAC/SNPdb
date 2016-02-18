# SNPdb
SNPdb Prototype
Directory Structure in git hub:

SNPDb
 ---CreatePopulateDB
      |	
      |---Java
	    |
	    |--SourceCode
	    |--executable
	    |--toydata

 ---SearchQuery
      |---Sql
      |---UI


## Prerequisites

* Java 8
* maven(in case if jar build from source code)
* mysql 5.1.61


## Directory Structure

*SourceCode- Directory contains the Souce code for data Population from flat file to database
*executable- it contain jar file.
*toydata- contains all the required input files for excuting a jar (i.e ChickenLine,Chromosome,all vcf files)
*Sql- Directory Contains the database Schema and the attahed Query file for two snp(i.e m1 and m3).


## Instructions
Clean by running `mvn clean`

Build by running `mvn package` or `mvn  install`

cd target (here SNPDbGenerator.jar will be generated )



## Command Line Execution

java -Ddb_password=<MysqlUserPassword> -Ddb_username=<MysqlUserName> -Ddb_url=<mysql Database url connection i.e(jdbc:mysql://localhost:3306/dbname)> -jar SNPDbGenerator.jar <File Path for ChickenLine> <File path for chromosome> <Directory path that contains all vcf file>





