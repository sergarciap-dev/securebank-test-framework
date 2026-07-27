@echo off
@REM Maven Wrapper para Windows
set MAVEN_PROJECTBASEDIR=%~dp0
set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
if exist %WRAPPER_JAR% goto runm2
echo Descargando Maven Wrapper...
powershell -Command "&{Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar' -OutFile '%WRAPPER_JAR%'}"
:runm2
java -classpath %WRAPPER_JAR% %WRAPPER_LAUNCHER% %*

