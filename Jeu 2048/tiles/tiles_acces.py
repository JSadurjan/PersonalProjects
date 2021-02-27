#!/usr/bin/env python

import sys
sys.path.append("../game")
sys.path.append("../ui")
sys.path.append("../life-cycle")

from play import *
from tiles_moves import *



def check_indice(plateau,indice):
  
    if indice<0 or indice >plateau['n']-1:
        return False
    return True



def test_check_indice():

    p=init_play()
    
    assert check_indice(p,0)
    assert check_indice(p,3)
    assert not check_indice(p,10)
    assert not check_indice(p,-1)
    assert not check_indice(p,4)
    
    print('test de la fonction check_indice : ok')
    




def check_room(plateau,lig,col):

    if not check_indice(plateau,lig) or not check_indice(plateau,col):
        return False
    return True




def test_check_room():

    p=init_play()
    
    assert check_room(p,2,1)
    assert check_room(p,3,3)
    assert not check_room(p,10,2)
    assert not check_room(p,-1,3)
    
    print('test de la fonction check_room : ok')
    




def get_value(plateau,lig,col):

    
    indice=lig*4+col
    
    return plateau['tiles'][indice]



def test_get_value():

    
    plateau={'n':4,
            'nombre_cases_libres' : 6,
            'tiles':[6,2,3,2,0,2,6,2,0,2,2,0,1,0,0,0]}
    p=plateau
    assert get_value(p,0,0)==6
    assert get_value(p,2,3)==0
    assert get_value(p,1,3)==2
    
    print('test de la fonction get_value : ok')
test_get_value()




def set_value(plateau,lig,col,val):

    
    
    indice=lig*4+col
    
    plateau['tiles'][indice]=val




def test_set_value():
    p=init_play()
    
    set_value(p,0,0,1)
    set_value(p,1,2,0)
    set_value(p,2,3,6)
    
    assert get_value(p,0,0)==1
    assert get_value(p,1,2)==0
    assert get_value(p,2,3)==6
    #assert set_value(p,18,2,6)
    
    
    
    print('test de la fonction set_value : ok')
    
    
    





def is_room_empty(plateau,lig,col):
  
    
    indice=lig*4+col
    
    if plateau['tiles'][indice]==0:
        return True
    else:
        return False
    




def test_is_room_empty():
    p=init_play()
    set_value(p,0,1,2)
    set_value(p,1,1,1)
    
    assert not is_room_empty(p,0,1)
    assert is_room_empty(p,3,2)
    #assert is_room_empty(15,2)
    
    print('Test de la foncion is_room_empty : ok')
    




