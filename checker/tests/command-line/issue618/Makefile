.PHONY: all

all:
	-$(JAVAC) -processor regex,org.checkerframework.checker.tainting.TaintingChecker TwoCheckers.java > out.txt 2>&1
	diff -u out.txt expected.txt
