#!/usr/bin/env python
# coding: utf-8

# In[3]:


import sys
sys.path.append("../Game")
sys.path.append("../Ui")
sys.path.append("..Life-cycle")
from play import *
from tiles_moves import *
from random import *


# In[1]:


def check_indice(plateau,indice):
    """Retourne True si l'indice correspond à un indice de case du plateau (compris entre 0 et n-1)"""

    if indice>=0 and indice<plateau['n']:
        return True
    else:
        return False

def test_check_indice():
    p= init_play()
    assert check_indice(p,0)== True
    assert check_indice(p,10)== False
    assert check_indice(p,3)== True
    assert check_indice(p,4)== False
    assert check_indice(p,-1)== False
    print('Test de la fonction check_indice: ok')
test_check_indice()


# In[7]:


def check_room(plateau,lig,col):
    """Retourne True si (lig,col) correspond à une case du plateau"""
    if 0<=lig<plateau['n'] and 0<=col<plateau['n']:
        return True
    else:
        return False
    
def test_check_room():
    p=init_play()
    assert check_room(p,2,3)== True
    assert check_room(p,10,4)== False
    assert check_room(p,10,1)==False
    assert check_room(p,3,0)==True
    assert check_room(p,-1,2)==False
    print('Test de la fonction check_room: ok')
test_check_room()


# In[7]:


def get_value(plateau,lig,col):
    """Retourne la valeur qu'il y a dans la case (lig,col)
       Erreur si (lig,col) non valide"""
    
    if check_room(plateau,lig,col)==False:
        return "Erreur, la case entrée n'est pas valide"
    else:
        case=lig*plateau['n']+col
        return(plateau["tiles"][case])

def test_get_value():
    p=init_play()
    assert get_value(p,0,0)==0
    assert get_value(p,2,3)==0
    assert get_value(p,1,3)==0
    assert get_value(p,3,0)==0
    assert get_value(p, 18,3)=="Erreur, la case entrée n'est pas valide"
    print('Test de la fonction get_value: ok')

test_get_value()


# In[9]:


def set_value(plateau,lig,col,val):
    """Affecte la valeur de val>=0 dans la case (lig,col) du plateau.
    Mise à jour du nb de cases libres. Erreur si (lig,col) existe pas ou val<0."""
    if check_room(plateau,lig,col)==False or val<0:
        print("La case ou la valeur entrée n'est pas valide")
    else:
        case=lig*plateau['n']+col
        plateau['tiles'][case]=val
        plateau['nombre_cases_libres']-=1

#Test
p=init_play()
set_value(p,0,0,1)
print("Test 1 effectué")
set_value(p,1,2,2)
print("Test 2 effectué")
set_value(p,18,3,1)
set_value(p,2,2,-1)
set_value(p,2,3,6)
print("Test 5 effectué")
print(p)


# In[11]:


def is_room_empty(plateau,lig,col):
    """Retourne True si la case du plateau est libre (c-à-d avec un 0)"""
    
    if check_room(plateau,lig,col)==False:
        return 'Erreur'
    case=lig*plateau['n']+col
    if plateau['tiles'][case]== 0:
        return True
    else:
        return False


def test_is_room_empty():
    p=init_play()
    assert is_room_empty(p,0,0)==True
    assert is_room_empty(p,0,3)==True
    assert is_room_empty(p,5,2)=='Erreur'
    print('Test de la fonction is_room_empty: ok')
    
test_is_room_empty()

