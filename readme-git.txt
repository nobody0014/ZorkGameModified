1 and 2 .idea/ folder and .iml
It is because .idea/ is a folder that intelliJ created and has no relavency to the project and without it
the project is completely workable.
It is because .iml is a folder that intelliJ created and has no relavency to the project and without it
the project is completely workable.

3 target folder
target folder is the result of "mvn package" therefore, it is not a source code and has no relevancy.

4 startZorkGameTest.sh
this is bash file used to test my game, the actual game playing use another bash file so i add this to gitignore.

Extra:
We did not ignore .txt files because it is the explanation file

