#!/usr/bin/env python
# coding: utf-8

# In[15]:


import sys
sys.path.append("../game")
sys.path.append("../tiles")
sys.path.append("..life-cycle")
from play import *
from tiles_acces import *
from tiles_moves import *
from string import *


# In[16]:


def simple_display(plateau):
    """Affichage simplifié"""
    line=""
    i=0
    while i<len(plateau['tiles']):
        line+=(str(plateau['tiles'][i])+" ")
        if i%4==3:
            print(line)
            line=""
            
        i+=1
        
        
p=init_play()

simple_display(p)


# In[88]:


def medium_display(plateau):
    """Affichage du plateau avec délimitaions textuelles des cases"""
    
    
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

    

    
medium_display(p)


# In[5]:


from termcolor import *


# In[10]:


text = colored('Hello, World!', 'red', attrs=['reverse', 'blink'])
print(text)
cprint('Hello, World!', 'green', 'on_red')

print_red_on_cyan = lambda x: cprint(x, 'red', 'on_cyan')
print_red_on_cyan('Hello, World!')
print_red_on_cyan('Hello, Universe!')

for i in range(10):
    cprint(i, 'magenta', end=' ')

cprint("Attention!", 'red', attrs=['bold'], file=sys.stderr)


# In[76]:


def full_display(plateau):
    """Affichage à l'aide de python termcolor"""
    
    i=0
    line=''
    feeding_line=''
    feeding="       \n"
    while i<len(plateau['tiles']):
        text=str(plateau['tiles'][i])
        if plateau['tiles'][i]==0:
            
            case=colored(text,'grey',attrs=['reverse','blink','concealed'])
        elif plateau['tiles'][i]==1:
            case=colored(feeding+text,'cyan',attrs=['reverse','blink'])
        elif plateau['tiles'][i]==2:
            case=colored(text,'blue',attrs=['reverse','blink'])
        else:
            case=colored(text,'green',attrs=['reverse','blink'])
        feeding_line+=feeding+' '  
        line+=case+' '
        if i%4==3:
            
            print(line)
            line=''
            feeding_line=''
        i+=1
full_display(p)

