import random
import os
from data import HANGMANPICS, word_list, win_art

game_continue = 'y'
while game_continue != 'n':
    life = 7
    game_over = 0
    # TODO 1. 랜덤으로 나오게 할 문자열을 지정한다. 문자열을 뽑는다.
    chosen_word = random.choice(word_list)
    print(chosen_word) #정답 확인용

    # TODO 2. 선택한 문자를 글자수를 세서 '_'를 출력한다.

    blank_answer = [] ##정답이 담길 빈칸
    answer_list = [] ##정답이 담길 칸
    user_guess_list = [] ##사용자가 유추한 답이 담길 리스트
    for j in range(0, len(chosen_word)):
        blank_answer.append("_")
    for i in chosen_word:
        answer_list.append(i)
    # print(answer_list) # 정답 확인용

    # TODO 3. 사용자에게 질문한다. 기회는 총 일곱번 준다.
    while game_over != 1:
        print(HANGMANPICS[7 - life])
        if len(user_guess_list) == 0:
            pass
        else:
            print(f"지금까지 유추한 단어: {', '.join(user_guess_list)}")
        print(' '.join(blank_answer))
        print(f"기회가 {life}번 남았습니다.")
        while True: # 예외처리 / 한글 한글자는 예외처리 못함
            user_guess = input("글자를 유추하세요: ").lower()
            if not user_guess.isalpha():
                print("문자로 입력하세요")
                continue
            if len(user_guess) >= 2:
                print("한 글자로만 입력하세요")
                continue
            else:
                break
        user_guess_list.append(user_guess)
        # TODO 4. 사용자가 유추한 글자 중 하나가 선택된 단어 안에 있으면 출력한다.
        if user_guess in answer_list:
            print("맞았습니다!")
            num = 0
            for m in chosen_word:
                if user_guess == m:
                    blank_answer[num] = m
                num += 1
            print(blank_answer)
        else:
            ## 없으면 생명을 하나 잃는다.
            print("틀렸습니다!")
            life -= 1
        os.system("cls")
        # TODO 5. 만약 5번의 기회 전에 다 맞추면 성공, 아니면 실피하며 정답을 출력한다.
        if answer_list == blank_answer: ## if '_' not in blank_answer 로 사용할 수 있을듯
            print(win_art)
            print(f"모두 맞췄습니다! 정답은 {chosen_word}입니다. 당신은 행맨을 구했습니다.")
            game_over = 1
        elif life == 0:
            print(HANGMANPICS[6])
            print("기회를 모두 소진했습니다. 당신은 한 목숨을 떠나보냈습니다...")
            print(f"게임 종료! 정답은 {chosen_word}이었습니다!")
            game_over = 1
    # TODO 6. 다시 시작할지 묻는다.
    game_continue = input("다시 하시겠습니까?(y/n): ").lower()
    if game_continue == 'y':
        os.system("cls")
