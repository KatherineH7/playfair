encode:encode.class
	java encode $(ARGS)

encode.class: encode.java
	javac encode.java

decode:decode.class
	java decode $(ARGS)

decode.class: decode.java
	javac decode.java

clean:
	$(RM) *.class
