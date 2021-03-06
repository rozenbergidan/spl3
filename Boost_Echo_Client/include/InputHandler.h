//
// Created by spl211 on 05/01/2021.
//

#ifndef BOOST_ECHO_CLIENT_INPUTHENDLER_H
#define BOOST_ECHO_CLIENT_INPUTHENDLER_H
#include <mutex>
#include "ConnectionHandler.h"



class InputHandler {
public:
    InputHandler(std::mutex & _mutex, ConnectionHandler &_connectionHandler, bool & _shouldTerminate, bool & _msgReceived);
    void run( );

private:

    std::mutex & mutex;
    ConnectionHandler &connectionHandler;
    bool &shouldTerminate;
    bool &msgReceived;

    void operationToCharArr(std::string operation, char *output);
    void opToFullMessage(std::string opCode, std::string line, char *output);
    void shortToBytes(short num, char* bytesArr);
    int getRestArrSize(std::string operation, std::string restOfLine);
    void stringToCharArr(std::string srt, char output[]);
    short stringToShort(std::string numAsString);

    void verifyValidInput(std::string &input);
};


#endif //BOOST_ECHO_CLIENT_INPUTHENDLER_H
