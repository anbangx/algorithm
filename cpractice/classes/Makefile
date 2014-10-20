CC = g++
CFLAGS = -Wall -g
LDFLAGS = -lm

IntList.o : IntList.cc IntList.h
	${CC} ${CFLAGS} -c IntList.cc

myprogram : IntList.o
	${CC} ${CFLAGS} IntList.o ${LDFLAGS} -o myprogram
