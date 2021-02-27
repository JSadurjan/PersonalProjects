#!/usr/bin/env python
# coding: utf-8

# In[1]:


import sys
sys.path.append("../game")
sys.path.append("../ui")
sys.path.append("../life_cycle")
from play import *
from tiles_acces import *
from random import *
from playcycle import *
from play_display import *


# In[2]:


def get_empty_room(plateau):
    """MàJ du nb de cases libres + Retourne la valeur"""
    
    cases_libres=0
    i=0
    while i<len(plateau['tiles']):
        if plateau['tiles'][i]==0:
            cases_libres+=1
        i+=1
    plateau["nombres_cases_libres"]=case_libres
    return plateau["nombre_cases_libres"]

p=init_play()
print(get_nb_empty_rooms(p))


# In[4]:


from random import *

def get_next_alea_tiles(plateau,mode):
    """Retourne une ou deux tuiles dont la position (lig,col)
    est tirée aléatoirement et correspond à un emplacement libre du plateau"""
    
    i=randint(0,3)
    j=randint(0,3)
        
    if is_room_empty(plateau,i,j)==True and mode=='init':
        tiles={'mode':'init',
             0:{'val':1, 'lig':i , 'col':j },
             1:{'val':2, 'lig':i , 'col':j },
             'check':is_game_over(plateau)}
    if  is_room_empty(plateau,i,j)==True and mode=='encours':
        x=randint(1,3)
        tiles={'mode':'encours',
             0:{'val':x, 'lig':i ,'col':j },
             'check': is_game_over(plateau)}
    return tiles

p=init_play()
test=get_next_alea_tiles(p,'encours')
print(test)


# In[6]:


def put_next_tiles(plateau,tiles):
    """Permet de placer une ou deux tuiles dans le plateau, tiles est le dico récup à la fonction précédente"""
    if tiles['mode']=='init':
        position_case_0=4*tiles[0]['lig']+tiles[0]['col']
        position_case_1=4*tiles[1]['lig']+tiles[1]['col']
        plateau['tiles'][position_case_0]=1
        plateau['tiles'][position_case_1]=2
    else:
        position_case_0=4*tiles[0]['lig']+tiles[0]['col']
        plateau['tiles'][position_case_0]=x


# In[8]:


def line_pack(plateau,num_lig,debut,sens):
    """Tasse les tuiles d'une ligne dans un sens donné, num_lig=indice de la ligne,
    debut= indice à partir duquel on tasse, sens=1 vers gauche, 0 vers droite"""
    
    i=debut
    if sens:
        while i<3:
            set_value(plateau,num_lig,i,plateau['tiles'][4*num_lig+i+1])
            i+=1
        if debut!=3:
            set_value(plateau,num_lig,i,0)
    else:
        while i>0:
            set_value(plateau,num_lig,i,plateau['tiles'][4*num_lig+i-1])
            i-=1
        if debut!=0:
            set_value(plateau,num_lig,i,0)
            
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,1,3,1)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,2,1)
medium_display(p)
line_pack(p,2,3,0)
line_pack(p,1,0,1)
medium_display(p)


# In[10]:


def column_pack(plateau,num_col,debut,sens):
    """Tasse les tuiles d'une colonne dans un sens donné, num_col=indice de la colonne,
    debut= indice à partir duquel on tasse, sens=1 vers haut, 0 vers bas"""

    i=debut
    if sens:
        while i<3:
            set_value(plateau,i,num_col,plateau['tiles'][(i+1)*4+num_col])
            i+=1
        if debut!=3:
            set_value(plateau,i,num_col,0)
            
            
    else:
        while i>0:
            
            set_value(plateau,i,num_col,plateau['tiles'][(i-1)*4+num_col])
            i-=1
        if debut!=0:
            set_value(plateau,i,num_col,0)
            
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,1,3,1)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,2,1)
medium_display(p)
column_pack(p,2,3,0)
column_pack(p,1,0,1)
medium_display(p)


# In[20]:


def line_move(plateau,num_lig,sens):
    """Déplacement des tuiles d'une ligne donnée dans un sens donné,
    num_lig= indice de la ligne,sens= 1 vers la gauche, 0 vers la droite"""
    
    if sens:
        i=0
        while i<3:
            case1=plateau['tiles'][4*num_lig+i]
            case2=plateau['tiles'][4*num_lig+i+1]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*num_lig+i+1]=case1+case2
                line_pack(plateau,num_lig,i,sens)
                i=3
            i+=1
                
    else:
        i=3
        while i>0:
            case1=plateau['tiles'][4*num_lig+i]
            case2=plateau['tiles'][4*num_lig+i-1]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*num_lig+i-1]=case1+case2
                line_pack(plateau,num_lig,i,sens)
                i=0
            i-=1


# In[23]:


def column_move(plateau,num_col,sens):
    """Déplacement des tuiles d'une colonnee donnée dans un sens donné,
    num_col= indice de la ligne,sens= 1 vers le haut, 0 vers le bas"""

    if sens:
        i=0
        while i<3:
            case1=plateau['tiles'][i*4+num_col]
            case2=plateau['tiles'][4*(i+1)+num_col]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3): 
                plateau['tiles'][4*(i+1)+num_col]=case1+case2
                column_pack(plateau,num_col,i,sens)
                i=3
            i+=1              
    else:
        i=3
        while i>0:
            case1=plateau['tiles'][i*4+num_col]
            case2=plateau['tiles'][4*(i-1)+num_col]
            if (case1+case2)%3==0 and (case1==case2 or case1+case2==3):
                plateau['tiles'][4*(i-1)+num_col]=case1+case2
                column_pack(plateau,num_col,i,sens)
                i=0
            i-=1
            
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,1,3,1)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,1,2)
set_value(p,2,2,1)
set_value(p,2,3,3)
set_value(p,3,1,1)
medium_display(p)
column_move(p,3,1)
medium_display(p)


# In[19]:


def lines_move(plateau,sens):
    """Déplacement des tuiles de toutes les lignes dans un sens donné, sens= 1 vers la gauche, 0 vers la droite"""
    i=0
    while i<4:
        line_move(plateau,i,sens)
        i+=1
        
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,2,1)
set_value(p,1,3,1)
set_value(p,2,1,2)
set_value(p,3,1,1)
set_value(p,2,3,3)
medium_display(p)
lines_move(p,0)
medium_display(p)


# In[22]:


def columns_move(plateau,sens):
    """Déplacement des tuiles de toutes les colonnes dans un sens donné, sens= 1 vers le haut, 0 vers le bas"""
    i=0
    while i<4:
        column_move(plateau,i,sens)
        i+=1
    
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,2,1)
set_value(p,1,3,1)
set_value(p,2,1,2)
set_value(p,3,1,1)
set_value(p,2,3,3)
medium_display(p)
columns_move(p,1)
medium_display(p)


# In[43]:


def play_move(plateau,sens):
    """Déplace les tuiles selon le sens, g=gauche, d=droite, h=haut, b=bas"""

    if sens=="g":
        lines_move(plateau,1)
    elif sens=='d':
        lines_move(plateau,0)
    elif sens=='h':
        columns_move(plateau,1)
    elif sens=='b':
        columns_move(plateau,0)
        
p=init_play()
set_value(p,1,1,3)
set_value(p,1,2,2)
set_value(p,0,3,2)
set_value(p,2,0,3)
set_value(p,2,2,1)
set_value(p,1,3,1)
set_value(p,2,1,2)
set_value(p,3,1,1)
set_value(p,2,3,3)
medium_display(p)
sens='d'
set_value(p,1,0,6)
play_move(p,sens)
medium_display(p)

