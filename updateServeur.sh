mvn clean install assembly:single -DskipTests=true
if [ $? -eq 0 ]
then
	cp scripts/* ../CodeStoryFinale-server/
	cp target/codestory-server.jar ../CodeStoryFinale-server/codestory-server.jar.new
	cd ../CodeStoryFinale-server
	./stopServeur.sh
	mv codestory-server.jar codestory-server.jar.old
	mv codestory-server.jar.new codestory-server.jar
	./startServeur.sh
	sleep 1
	tail -10 serveur.log
fi

