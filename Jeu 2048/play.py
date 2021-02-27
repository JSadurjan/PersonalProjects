#!/usr/bin/env python
# coding: utf-8

# In[1]:


import sys
sys.path.append("../")
sys.path.append("../Ui")
sys.path.append("..Life-cycle")

from tiles_moves import *
from tiles_acces import *
from play_display import *


# In[7]:


def init_play():
    """Retourne un plateau correspondant à une nouvelle partie.
    Une nouvelle partie est un dictionnaire avec le clefs et valeurs suivantes:
    'n':4  'nb_cases_libres':16  'tiles':tableau de 4*4 cases
    """
    tab=[]
    i=0
    while i<16:
        tab.append(0)
        i+=1
    plateau={'n':4, 'nombre_cases_libres':16, 'tiles':tab}
    return plateau

p= init_play()
print(p)


# In[8]:


def is_game_over(plateau):
    """Retourne True si la partie est terminée"""
    
    if 0 not in plateau['tiles']:
        return True
    else:
        return False
def test_is_game_over():   
    plateau={'n':4, 'nombre_cases_libres':6, 'tiles':[6,0,3,2,0,2,6,2,0,0,2,2,1,4,0,0]}
    assert is_game_over(plateau)==False
    plateau={'n':4, 'nombre_cases_libres':0, 'tiles':[6,2,3,2,1,2,6,2,6,4,2,2,1,4,3,3]}
    assert is_game_over(plateau)==True
    print('Test de la fonction is_game_over: ok')
    
test_is_game_over()


# In[9]:


def get_score(plateau):
    """Retourne le score du plateau"""
    
    i=0
    score=0
    while i<len(plateau['tiles']):
        score+=plateau['tiles'][i]
        i=i+1
    return score

def test_get_score():
    plateau={'n':4, 'nombre_cases_libres':6, 'tiles':[6,0,3,2,0,2,6,2,0,0,2,2,1,4,0,0]}
    assert get_score(plateau)==30
    plateau={'n':4, 'nombre_cases_libres':0, 'tiles':[6,2,3,2,1,2,6,2,6,4,2,2,1,4,3,3]}
    assert get_score(plateau)==49
    plateau={'n':4, 'nombre_cases_libres':0, 'tiles':[0,0,0,0,0,0,0,2,0,0,0,0,1,0,0,0]}
    assert get_score(plateau)==3
    print('Test de la fonction get_score: ok')

test_get_score()


# In[12]:


def test_get_score():
    """Vérifie si la fonction get_score est valide"""
    p=init_play()
    assert get_score(p)==0
    p['tiles']=[1,2,3,12,12,3,12,6,2,3,6,2,3,1,1,3]
    assert get_score(p)==72
    
    
    print('Test de la fonction get_score : ok')

test_get_score()


# In[11]:


def create_new_play(n):
    """Créer et retourne une nouvelle partie"""
    p=init_play()
    initialisation=get_next_alea_tiles(p,'init')
    put_next_tiles(p,initialisation)
    get_empty_room(p)
    score=get_score(p)
    next_tile=get_next_alea_tiles(p,'encours')
    partie={}
    partie['plateau']=p
    partie['next_tile']=next_tile
    partie['score']=score
    
    return partie


# In[14]:


partie1=create_new_play(1)
print (partie1)

