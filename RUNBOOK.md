# Runbook

## Перед push: git status clean

Перед каждым `git push` проверить:
- PowerShell: `git status` → "nothing to commit, working tree clean"
- IDE: Commit Tool Window → списки Changes и Unversioned пусты

Если появился мусор (.idea, build, out):
1. Убедиться что папка есть в `.gitignore`
2. `git rm -r --cached <папка>`
3. `git add .gitignore`
4. `git commit -m "Очистить репозиторий; обновить .gitignore"`
5. Коммит делать отдельно от функциональных изменений