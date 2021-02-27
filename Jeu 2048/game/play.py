#!/usr/bin/env python


import sys
sys.path.append("../tiles")
sys.path.append("../ui")
sys.path.append("../life-cycle")

from tiles_acces import *
from tiles_moves import *
from play_display import *



def init_play():

    
    
    tab=[]
    i=0
    while i<16:
        tab.append(0)
        i+=1
    
    dico={}
    
    dico['n']=4
    dico['nb_cases_libres']=16
    dico['tiles']=tab
    
    return dico


def test_init_play():
    
    test=init_play()
    
    assert test['n']==4, 'n doit valoir 4'
    assert test['nb_cases_libres']==16, 'nb_cases_libres doit valoir 16'
    assert test['tiles']== [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    
    print('test de la fonction init_play : ok')
    
test_init_play()

def is_game_over(plateau):

    
    if not 0 in plateau['tiles']:
        return True
    else:
        return False



def test_is_game_over():

    p=init_play()
    
    assert not is_game_over(p)
    
    p['tiles']=[1,2,3,12,12,3,12,6,2,3,6,2,3,1,1,3]
    
    assert is_game_over(p)
    
    print("Test del a fonction is_game_over : ok")
    
test_is_game_over()



def get_score(plateau):

    
    i=0
    somme=0
    while i<len(plateau['tiles']):
        somme+=plateau['tiles'][i]
        i+=1
    return somme


def test_get_score():

    p=init_play()
    assert get_score(p)==0
    p['tiles']=[1,2,3,12,12,3,12,6,2,3,6,2,3,1,1,3]
    assert get_score(p)==72
    
    
    print('Test de la fonction get_score : ok')

def create_new_play(n):

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