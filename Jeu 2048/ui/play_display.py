#!/usr/bin/env python


import sys
sys.path.append("../game")
sys.path.append("../tiles")
sys.path.append("..life-cycle")

from play import *
from string import *
from termcolor import *

def simple_display(plateau):

    line=""
    i=0
    while i<len(plateau['tiles']):
        line+=(str(plateau['tiles'][i])+" ")
        if i%4==3:
            print(line)
            line=""
            
        i+=1
        
        





def medium_display(plateau):

    
    borderline=""
    i=0
    while i<33:
        borderline+="*"
        i+=1
    
    borderSec=""
    i=0
    while i<33:
        if i%8==0:
            borderSec+="*"
        else:
            borderSec+=" "
        i+=1
    
    i=0
    line=""
    while i<len(plateau['tiles']):
        line+=("*"+str(plateau['tiles'][i]).center(7))
        if i%4==3:
            line+="*"
            print(borderline)
            print(borderSec)
            print(line)
            print(borderSec)
            line=""
        i+=1
    print(borderline)

    

def full_display(plateau):
    """Affichage à l'aide de python termcolor"""
    
    i=0
    line=''
    while i<len(plateau['tiles']):
        text=str(plateau['tiles'][i]).center(7)
        if plateau['tiles'][i]==0:          
            case=colored(text,'grey',attrs=['reverse','blink'])
        elif plateau['tiles'][i]==1:
            case=colored(text,'cyan',attrs=['reverse','blink'])
        elif plateau['tiles'][i]==2:
            case=colored(text,'blue',attrs=['reverse','blink'])
        else:
            case=colored(text,'green',attrs=['reverse','blink'])
            
        line+=case
        if i%4==3:
            print(line)
            line=''            
        i+=1  