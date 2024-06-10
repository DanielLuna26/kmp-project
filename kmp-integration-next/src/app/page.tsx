import dynamic from 'next/dynamic';

const LaunchesList = dynamic(() => import('../../components/LaunchesLists'), { ssr: false }); 

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <LaunchesList />
    </main>
  );
}
