import pygame
import random
import sys

pygame.init()

# 색상 정의
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

# 화면 크기 설정
size = (500, 600)
screen = pygame.display.set_mode(size)

# Pygame Clock 객체 생성
clock = pygame.time.Clock()

# 이미지 로드 및 크기 조정
player = pygame.image.load('images/CAT.png')
player = pygame.transform.scale(player, (70, 95))
apple = pygame.image.load('images/apple.png')
apple = pygame.transform.scale(apple, (80, 80))
peach = pygame.image.load('images/peach.png')
peach = pygame.transform.scale(peach, (80, 80))
banana = pygame.image.load('images/banana.png')
banana = pygame.transform.scale(banana, (80, 80))
grape = pygame.image.load('images/grape.png')
grape = pygame.transform.scale(grape, (80, 80))
strawberry = pygame.image.load('images/strawberry.png')
strawberry = pygame.transform.scale(strawberry, (80, 80))
bomb = pygame.image.load('images/bomb.png')
bomb = pygame.transform.scale(bomb, (90, 90))
heart = pygame.image.load('images/heart.png')
heart = pygame.transform.scale(heart, (40, 40))

# 배경 이미지 로드 및 크기 조정
background = pygame.image.load('images/background.png')
background = pygame.transform.scale(background, size)

# 배경음악 사운드
pygame.mixer.music.load('sounds/Bg_music.wav')
eat_apple = pygame.mixer.Sound('sounds/up.wav')
eat_grape = pygame.mixer.Sound('sounds/up.wav')
eat_peach = pygame.mixer.Sound('sounds/up.wav')
eat_banana = pygame.mixer.Sound('sounds/up.wav')
eat_strawberry = pygame.mixer.Sound('sounds/up.wav')
hit_poop = pygame.mixer.Sound('sounds/poop.wav')
end = pygame.mixer.Sound('sounds/end.wav')

# 폰트 설정
font = pygame.font.SysFont(None, 36)

# 장애물 클래스 정의
class Obstacle:
    def __init__(self, x, y, image, speed):
        self.x = x
        self.y = y
        self.image = image
        self.speed = speed

    def move(self):
        self.y += self.speed

    def draw(self):
        screen.blit(self.image, (self.x, self.y))

    def reset_pos(self):
        self.x = random.randint(0, size[0] - self.image.get_width())
        self.y = -self.image.get_height()
        self.speed = random.randint(3, 6)

# 게임 실행 함수 정의
def runGame():
    pygame.mixer.music.play(-1)# 음악 무한루프
    x = 20
    y = size[1] - 90
    speed = 5
    score = 0
    lives = 3
    start_time = pygame.time.get_ticks()  # 게임 시작 시간

    # 장애물 리스트 생성
    obstacles = []
    for i in range(5):
        obstacle_type = random.choice([apple,grape,banana,peach, strawberry, bomb, heart])
        obstacle = Obstacle(random.randint(0, size[0] - 30), -30, obstacle_type, random.randint(7, 20))
        obstacles.append(obstacle)

    done = False

    while not done:
        clock.tick(30)  # 초당 30 프레임으로 설정
        screen.blit(background, (0, 0))  # 배경 이미지 그리기

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                done = True

        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            x -= speed
        if keys[pygame.K_RIGHT]:
            x += speed

        if x < 0:
            x = 0
        elif x > size[0] - 60:
            x = size[0] - 60

        # 현재 경과 시간 계산
        current_time = pygame.time.get_ticks()
        elapsed_time = (current_time - start_time) / 1000  # 밀리초를 초로 변환

        if elapsed_time >= 180:  # 3분(180초)이 경과하면 게임 종료
            done = True

        # 장애물 이동 및 충돌 처리
        for obstacle in obstacles:
            obstacle.move()
            if obstacle.y > size[1]:
                obstacle.reset_pos()

            if x < obstacle.x < x + 60 and y < obstacle.y < y + 45:
                if obstacle.image == grape:
                    score += 10
                    eat_grape.play()  # 포도를 먹을 때 소리 재생
                    obstacle.reset_pos()
                if obstacle.image == apple:
                    score += 15
                    eat_apple.play()  # 사과를 먹을 때 소리 재생
                    obstacle.reset_pos()                    
                if obstacle.image == peach:
                    score += 20
                    eat_peach.play()  # 복숭아를 먹을 때 소리 재생
                    obstacle.reset_pos()                    
                if obstacle.image == banana:
                    score += 25
                    eat_banana.play()  # 바나나를 먹을 때 소리 재생
                    obstacle.reset_pos()          
                if obstacle.image == strawberry:
                    score += 30
                    eat_strawberry.play()  # 바나나를 먹을 때 소리 재생
                    obstacle.reset_pos()                         
                elif obstacle.image == bomb:
                    lives -= 1
                    hit_poop.play() #똥 먹음 사운드
                    if lives == 0:
                        done = True
                    obstacle.reset_pos()
                elif obstacle.image == heart: # 하트 이미지와 충동할 때
                    if lives < 3: # 목숨의 최대치를 3개까지로 조정
                        lives += 1  # 목숨 +1
                    obstacle.reset_pos()
                    eat_apple.play()

            obstacle.draw()

        screen.blit(player, (x, y))

        score_text = font.render(f'Score: {score}', True, BLACK)
        screen.blit(score_text, (10, 10))

        lives_text = font.render(f'Lives: {lives}', True, BLACK)
        screen.blit(lives_text, (size[0] - 120, 40))

        # 남은 시간 표시
        time_remaining = font.render(f'Time Left: {180 - int(elapsed_time)}', True, BLACK)
        screen.blit(time_remaining, (size[0] - 180, 10))

        pygame.display.update()
        
    pygame.mixer.music.stop() #게임 끝나면 음악 종료
    end.play() #죽으면 브금
    show_game_over_screen(score)

def show_game_over_screen(score):
    screen.fill(WHITE)
    game_over_text = font.render('Game Over', True, BLACK)
    final_score_text = font.render(f'Final Score: {score}', True, BLACK)
    screen.blit(game_over_text, (size[0] // 2 - game_over_text.get_width() // 2, size[1] // 2 - 50))
    screen.blit(final_score_text, (size[0] // 2 - final_score_text.get_width() // 2, size[1] // 2 + 10))
    pygame.display.update()
    pygame.time.wait(3000)
    pygame.quit()
    sys.exit()

runGame()
