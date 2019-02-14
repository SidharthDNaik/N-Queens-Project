#--------------------------------------------------------------------------------------
# Name: Sidharth Naik
# ID: 1647945
# Class: 12B/M
# Date: February 4,2018
# Description: Compiles all the code
# File Name: Makefile
#---------------------------------------------------------------------------------------

JAVASRC	= Queens.java
SOURCES	= README Makefile $(JAVASRC)
MAINCLASS	= Queens
CLASSES = Queens.class
JARFILE = Queens
SUBMIT = submit cmps012b-pt.w19 pa2

all: $(JARFILE)

$(JARFILE) : $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)
#The lines above check if the Class files exist and are up to date and constructs them

$(CLASSES): $(JAVASRC)
		javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
#Gets rid of all the previously compiled stuff

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w19/pa2/sidnaik
