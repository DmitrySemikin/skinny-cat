# $ java -cp h2-2.1.210.jar org.h2.tools.Server -help          Starts the H2 Console (web-) server, TCP, and PG server.
#Usage: java org.h2.tools.Server <options>
#When running without options, -tcp, -web, -browser and -pg are started.
#
#Options are case sensitive.
#Supported options[-help] or [-?]Print the list of options
#[-web]                  Start the web server with the H2 Console
#[-webAllowOthers]       Allow other computers to connect - see below
#[-webDaemon]            Use a daemon thread
#[-webPort <port>]       The port (default: 8082)
#[-webSSL]               Use encrypted (HTTPS) connections
#[-webAdminPassword]     Password of DB Console administrator
#[-browser]              Start a browser connecting to the web server
#[-tcp]                  Start the TCP server
#[-tcpAllowOthers]       Allow other computers to connect - see below
#[-tcpDaemon]            Use a daemon thread
#[-tcpPort <port>]       The port (default: 9092)
#[-tcpSSL]               Use encrypted (SSL) connections
#[-tcpPassword <pwd>]    The password for shutting down a TCP server
#[-tcpShutdown "<url>"]  Stop the TCP server; example: tcp://localhost
#[-tcpShutdownForce]     Do not wait until all connections are closed
#[-pg]                   Start the PG server
#[-pgAllowOthers]        Allow other computers to connect - see below
#[-pgDaemon]             Use a daemon thread
#[-pgPort <port>]        The port (default: 5435)
#[-properties "<dir>"]   Server properties (default: ~, disable: null)
#[-baseDir <dir>]        The base directory for H2 databases (all servers)
#[-ifExists]             Only existing databases may be opened (all servers)
#[-ifNotExists]          Databases are created when accessed
#[-trace]                Print additional trace information (all servers)
#[-key <from> <to>]      Allows to map a database name to another (all servers)
#The options -xAllowOthers are potentially risky.

$dbBaseDir = "$PSScriptRoot\..\..\h2-2.1-storage"
New-Item -Type Directory -Force "$dbBaseDir"

# Allow DB creation on connect:
#java.exe -cp "$PSScriptRoot\..\..\h2-2022-01-17\h2\bin\h2-2.1.210.jar" org.h2.tools.Server -web -tcp -baseDir "$dbBaseDir" -ifNotExists

# Don't allow DB creation on connect (db must exist)
java.exe -cp "$PSScriptRoot\..\..\h2-2022-01-17\h2\bin\h2-2.1.210.jar" org.h2.tools.Server -web -tcp -baseDir "$dbBaseDir" -ifExists

# Connection string: jdbc:h2:tcp://localhost/skinnycat
