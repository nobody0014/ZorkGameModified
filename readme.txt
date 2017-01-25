1) Plugins
Include Shade Plugin in Plguins for configuration of the jar file and dependencies incase we have dependecies.

2) Dependecies
We include junit as dependencies in case we want to test our program.

3) Compilation
"mvn clean package" in order to get the target folder and give a file name ZorkGame.jar in it.
The configuration to final name ZorkGame.jar is in the shade plugin.
It is also specified that the main class is in the ZorkGame in package io.muic.ooc.

4)
run the bash file with command "./startZorkGame.sh" --> do not forget to turn it into a executable
Within that sh file it contains the following line:
java -jar target/ZorkGame.jar

This is so that u dont have to go into target folder.




