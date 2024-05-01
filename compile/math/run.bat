@echo off

echo ________________
echo [COMPILING MATH]

rem Compiling
"%JAVA_HOME%/bin/javac" "@compile/math/cFile" "-encoding" "utf-8" "-cp" "plugins/;" "-d" "plugins/math-comp"

echo Compiling finish

rem Packing

"%JAVA_HOME%/bin/jar" "-cfm" "plugins/math.jar" "plugins/math/MANIFEST.MF" "-C" "plugins/math-comp" "math/"

rem Run vanilla compile
"compile/vanilla/run"