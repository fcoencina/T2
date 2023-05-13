
JFLAGS = -g
JC = javac
JVM = java
JFX_OPTIONS = /home/kaliostro/javafx-sdk-17.0.7/lib
FILE = "config.txt"
MAIN = Stage1
JavaFX = --module-path $(JFX_OPTIONS) --add-modules javafx.controls

*.class: *.java
	$(JC) $(JFLAGS) $(JavaFX) *.java

run: $(MAIN).class
	$(JVM) $(JavaFX) $(MAIN) $(FILE)

clean:
	$(RM) *.class

