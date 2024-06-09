import random
count =0

while True:
    rn = random.randint(1, 3)
    if rn==1:
        com = '가위'
    elif rn==2:
        com = '바위'
    elif rn==3:
        com = '보'
        
    player = input("가위, 바위, 보 중 하나를 입력하세요.")
    if player =='가위' or player =='보' or player=='바위' :
        if (com=='가위' and player== '보') or(com=='바위' and player== '가위') or(com=='보' and player== '바위') :
            print('com='+com+'  player='+player+' is com win')
                    
        elif (com=='보' and player== '가위') or(com=='가위' and player== '바위') or(com=='바위' and player== '보') :
            print('com='+com+'  player='+player+' is player win')
            count += 1
            if count >=3 :
                print("player가 3승으로 종료합니다.")
                break
        else :
            print('com='+com+'  player='+player+' is draw')                  
    else :
        print("잘못 입력했습니다.")
        continue
