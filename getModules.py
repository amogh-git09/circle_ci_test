import sys

def stripQuotes(s):
    if (s[0] == s[-1]) and s.startswith(("'", '"')):
        return s[1:-1]
    return s

def writeModules(readFileName, writeFileName):
    readFile = open(readFileName, "r")
    writeFile = open(writeFileName, "w")
    str = readFile.read().split('\n')
    list = []
    for s in str:
        split = s.split(' ', 1)
        if split[0] == "include":
            writeFile.write(stripQuotes(split[1]) + "\n")

writeModules("settings.gradle", "__module_list.txt")
