#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
#include <time.h>
using namespace std;

string randomName(int rand1, int rand2)
{
    string firstNames[] = {"John", "Jane", "Michael", "David", "Sarah", "Emily", "William", "Olivia", "James", "Emma"};
    string lastNames[] = {"Smith", "Johnson", "Brown", "Taylor", "Miller", "Wilson", "Davis", "Clark", "Hall", "Lee"};
    return firstNames[rand1] + " " + lastNames[rand2];
}

string generateUniqueId()
{
    string randomString = "";
    for (int i = 0; i < 8; i++)
    {
        int randomNumber = rand() % 10;
        randomString += to_string(randomNumber);
    }
    return randomString;
}

int main()
{
    srand(time(NULL));
    ofstream file("students.txt");
    file << "Data Base" << "," << "CSE123s" << "," << 100 << endl;
    for (int i = 0; i < 1000; i++)
    {
        int nameIndex1 = rand() % 10, nameIndex2 = rand() % 10;
        file << randomName(nameIndex1, nameIndex2) << "," << generateUniqueId() << 
        "," << rand() % 11 << "," << rand() % 11 << "," << rand() % 21 << "," << rand() % 61;
        file << endl;
    }
    return 0;
}