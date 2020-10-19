run:Main.class
	java Main $(ARGS)

Main.class: Main.java
	javac Main.java

clean:
	$(RM) *.class
