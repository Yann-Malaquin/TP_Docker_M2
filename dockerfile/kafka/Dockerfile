FROM confluentinc/cp-kafka:6.1.1

CMD kafka-topics --bootstrap-server kafka:9092 --list && \
    kafka-topics --bootstrap-server kafka:9092 --create --if-not-exists --topic annuaire --replication-factor 1 --partitions 1 && \
    kafka-topics --bootstrap-server kafka:9092 --list
