import git
from git import Repo
from datetime import datetime

my_repo = git.Repo('EDA2_Work_1')
repo = Repo('EDA2_Work_1')


def main():
    while True:
        texto = input("Escreva push ou pull : ")
        if texto == ".":
            repo.git.add('.')
            repo.git.commit('-m', datetime.today())
            origin = repo.remote(name='origin')
            origin.push()
            print(f'commit: {datetime.today()}')
            exit()
        if texto=="push":
            repo.git.add('.')
            repo.git.commit('-m', datetime.today())
            origin = repo.remote(name='origin')
            origin.push()
            print(f'commit: {datetime.today()}')
        if texto=="pull":
            origin.pull()
        


with repo.config_writer() as git_config:
    git_config.set_value('user', 'email', 'gbarradas1@hotmail.com')
    git_config.set_value('user', 'name', 'Gbarradas')

with repo.config_reader() as git_config:
    print(git_config.get_value('user', 'email'))
    print(git_config.get_value('user', 'name'))


# List remotes
print('Remotes:')
for remote in repo.remotes:
    print(f'- {remote.name} {remote.url}')
try:
    remote = repo.create_remote('origin', url='git@github.com:GBarradas/degreeStuff.git')
except git.exc.GitCommandError as error:
    print(f'Error creating remote: {error}')


main()