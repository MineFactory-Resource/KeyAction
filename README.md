# KeyAction

## Description
'특정한 키 입력'을 통해 사용자가 설정한 '명령어'를 '지정한 레벨'에서 실행시킬 수 있도록 해주는 플러그인입니다.

해당 플러그인은 PlaceholderAPI를 지원합니다.
### Use Spigot Version: 
1.17.1  
### Tested Spigot Version: 
1.17.1  
### Required Plugin: 
PlaceholderAPI (Optional)

## Install Guide
1. [Releases](https://github.com/MineFactory-Resource/KeyCommand/releases) 항목에서 최신 버전의 플러그인 파일을 다운로드합니다.
2. 다운로드한 *.jar 파일을 플러그인 디렉토리에 저장합니다.

## Feature
config.yml 양식은 아래와 같습니다.
```yaml
command:
  - '[레벨] 명령어1'
  - '[레벨] 명령어2'
  - '[레벨] 명령어3'

action: 특정한 키
```
레벨은 PLAYER, OP, CONSOLE 으로 총 3가지가 존재합니다.
- PLAYER 레벨은 명령어를 플레이어의 권한으로 실행합니다.
- OP 레벨은 명령어를 OP 권한으로 실행합니다.
- CONSOLE 레벨은 명령어를 CONSOLE 에서 실행합니다.

명령어를 설정하실 때 '/'를 제외하고 설정하여야 합니다.

특정한 키는 SHIFT, F, SHIFT+F 으로 총 3가지가 존재합니다.
- SHIFT 키는 플레이어가 앉았을 때 명령어를 실행합니다.
- F 키는 플레이어가 양손에 있는 아이템을 맞바꾸었을 때 명령어를 실행합니다.
- SHIFT+F 키는 플레이어가 앉은 상태에서 양손에 있는 아이템을 맞바꾸었을 때 명령어를 실행합니다.

EXAMPLE:
```yaml
command:
  - '[CONSOLE] weather rain'     # /weather rain 을 Console 에서 실행합니다.
  - '[PLAYER] help'              # /help 를 Player 권한으로 실행합니다.
  - '[OP] gamemode creative'     # /gamemode creative 를 OP 권한으로 실행합니다.

action: SHIFT                    # SHIFT 키 입력 시 설정한 명령어들이 실행됩니다.
```

## Commands
None

## Permissions
None