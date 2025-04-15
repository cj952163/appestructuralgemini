#!/bin/bash

# Asegúrate de estar en el directorio raíz del proyecto
cd "$(dirname "$0")"

# Inicializa un repositorio Git local
git init

# Agrega todos los archivos al staging area
git add .

# Realiza el commit inicial
git commit -m "Initial commit: Proyecto base y estructura de archivos"

echo "Repositorio Git local inicializado y commit inicial realizado."
echo "Ahora puedes crear un repositorio remoto (e.g., en GitHub, GitLab, Bitbucket)"
echo "y luego vincular este repositorio local con el remoto usando 'git remote add origin <URL_DEL_REPOSITORIO_REMOTO>'."
