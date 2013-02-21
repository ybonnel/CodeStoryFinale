ps -ef | grep java | grep codestory | grep -v grep | while read a b c
do
	kill -9 $b
done
