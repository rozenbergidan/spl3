//
// Created by spl211 on 05/01/2021.
//

#ifndef BOOST_ECHO_CLIENT_INPUTHENDLER_H
#define BOOST_ECHO_CLIENT_INPUTHENDLER_H
#include <mutex>
#include "ConnectionHandler.h"
#include <queue>


class InputHendler {
public:
    InputHendler(std::mutex & _mutex, ConnectionHandler &_connectionHandler);
    void run( );

private:

    std::mutex & mutex;
    ConnectionHandler &connectionHandler;

    void oprationToCharArr(std::string operation, char output[]);
    void opTofullMessage(std::string opCode,std::string line, char output[]);
    void shortToBytes(short num, char* bytesArr);
    int getRestArrSize(std::string operation, std::string restOfLine);
    void stringToCharArr(std::string srt, char output[]);
    short stringToShort(std::string numAsString);

    void vetifyValidInput(std::string &input);
};


#endif //BOOST_ECHO_CLIENT_INPUTHENDLER_H