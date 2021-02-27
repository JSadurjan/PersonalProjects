#!/usr/bin/env python

import sys
sys.path.append("../game")
sys.path.append("../ui")
sys.path.append("../life-cycle")
from play import *
from tiles_acces import *
from random import *

def is_room_empty(plateau,lig,col):
  
    
    indice=lig*4+col
    
    if plateau['tiles'][indice]==0:
        return True
    else:
        return False
        
def set_value(plateau,lig,col,val):

    
    
    indice=lig*4+col
    
    plateau['tiles'][indice]=val



def is_game_over(plateau):

    
    if not 0 in plateau['tiles']:
        return True
    else:
        return False



def get_empty_room(plateau):

    
    compteur=0
    i=0
    while i<len(plateau['tiles']):
        if plateau['tiles'][i]==0:
            compteur+=1
        i+=1
    
    plateau['nb_cases_libre']=compteur
    
    return compteur



def test_get_empty_room():

    p=init_play()
    
    assert get_empty_room(p)==16
    set_value(p,2,3,4)
    assert get_empty_room(p)==15
    set_value(p,1,2,3)
    set_value(p,3,3,1)
    assert get_empty_room(p)==13
    set_value(p,2,3,0)
    assert get_empty_room(p)==14
    
    print('Test de la fonction get_empty_room : ok')
    


def get_next_alea_tiles(plateau,mode):

    dico={}
    tuile1={}
    tuile2={}
    
    if mode=='init':
        
        dico['mode']=mode
        indice1=randint(0,15)
        
        
        
        indice2=indice1           
        while indice2==indice1:
            indice2=randint(0,15) 
            
            
        tuile1['val']=1
        tuile1['lig']=int(indice1/4)            
        tuile1['col']=indice1-4*int(indice1/4) 
       
        tuile2['val']=2
        tuile2['lig']=int(indice2/4)
        tuile2['col']=indice2-4*int(indice2/4)
        
        dico['t1']=tuile1
        dico['t2']=tuile2
    
    if mode=='encours':
        dico['mode']=mode
        test=False
        i=0
        while not test and i<16:
            indice1=randint(0,15)
            test=is_room_empty(plateau,int(indice1/4),indice1-4*int(indice1/4))
            i+=1
        
        tuile1['val']=randint(1,3)
        tuile1['lig']=int(indice1/4)            
        tuile1['col']=indice1-4*int(indice1/4)
        dico['t1']=tuile1
        
    if is_game_over(plateau):
        dico['check']=False
    else:
        dico['check']=True
    
    return dico



def put_next_tiles(plateau,tiles):
    if tiles['mode']=='init':
        set_value(plateau,tiles['t1']['lig'],tiles['t1']['col'],tiles['t1']['val'])
        set_value(plateau,tiles['t2']['lig'],tiles['t2']['col'],tiles['t2']['val'])
    else:
        set_value(plateau,tiles['t1']['lig'],tiles['t1']['col'],tiles['t1']['val'])
    

def line_pack(plateau,nligne,debut,sens):

    
    i=debut
    if sens:
        while i<3:
            set_value(plateau,nligne,i,plateau['tiles'][4*nligne+i+1])
            i+=1
        if debut!=3:
            set_value(plateau,nligne,i,0)
    else:
        while i>0:
            set_value(plateau,nligne,i,plateau['tiles'][4*nligne+i-1])
            i-=1
        if debut!=0:
            set_value(plateau,nligne,i,0)    



def colum_pack(plateau,ncol,debut,sens):

    i=debut
    if sens:
        while i<3:
            set_value(plateau,i,ncol,plateau['tiles'][(i+1)*4+ncol])
            i+=1
        if debut!=3:
            set_value(plateau,i,ncol,0)
            
            
    else:
        while i>0:
            
            set_value(plateau,i,ncol,plateau['tiles'][(i-1)*4+ncol])
            i-=1
        if debut!=0:
            set_value(plateau,i,ncol,0)


def line_move(plateau,nligne,sens):
    
    if sens:
        i=0
        while i<3:
            case1=plateau['tiles'][4*nligne+i]
            case2=plateau['tiles'][4*nligne+i+1]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*nligne+i+1]=case1+case2
                line_pack(plateau,nligne,i,sens)
                i=3
            
            i+=1
                
    else:
        i=3
        while i>0:
            case1=plateau['tiles'][4*nligne+i]
            case2=plateau['tiles'][4*nligne+i-1]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*nligne+i-1]=case1+case2
                line_pack(plateau,nligne,i,sens)
                i=0
            i-=1
            

def colum_move(plateau,ncol,sens):

 
    if sens:
        i=0
        while i<3:
            case1=plateau['tiles'][i*4+ncol]
            case2=plateau['tiles'][4*(i+1)+ncol]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3): 
                plateau['tiles'][4*(i+1)+ncol]=case1+case2
                colum_pack(plateau,ncol,i,sens)
                i=3
            
            i+=1
                
    else:
        i=3
        while i>0:
            case1=plateau['tiles'][i*4+ncol]
            case2=plateau['tiles'][4*(i-1)+ncol]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*(i-1)+ncol]=case1+case2
                colum_pack(plateau,ncol,i,sens)
                i=0
            i-=1

def lines_move(plateau,sens):

    i=0
    while i<4:
        line_move(plateau,i,sens)
        i+=1

def colums_move(plateau,sens):

    i=0
    while i<4:
        colum_move(plateau,i,sens)
        i+=1

def play_move(plateau,sens):

    if sens=="g":
        lines_move(plateau,1)
    elif sens=='d':
        lines_move(plateau,0)
    elif sens=='h':
        colums_move(plateau,1)
    else:
        colums_move(plateau,0)